class BooksController < ApplicationController

  include CommonActions

  before_action :set_user

  def list
    user_id = params[:user_id]
    user =  User.where(:id =>user_id).first
    @is_admin = user.present? ? user.is_admin : false
    @user =user
    @book =[]
    if(params[:query]).present?
      books_list = Book.search_active(params[:query])
      if books_list.present?
        @book = books_list.records.to_a
      end
    else
      @book = Book.where(is_deleted: 0)
    end
  end

  def edit
    id =params[:id]
    @user_id =params[:user_id]
    @book =Book.find(id)

  end

  def update
    id =params[:id]
    @user_id =params[:user_id]
    @book = Book.find(id)
    @book.update(book_params)
      # redirect_to book_details_path(book,user_id: user_id)
       render "/books/show"
  end

  def show
    id = params[:id]
    @book = Book.find(id)
    @user_id = params[:user_id]
    user = User.where(:id =>id).first
    @is_admin = user.present? ? user.is_admin : false
  end

  def delete
    @user_id=params[:user_id]
    id = params[:id]
    @book = Book.find(id)
    @book.delete
    flash[:notice] = "Book #{@book.name} deleted"
    redirect_to list_books_path(:user_id => @user_id)
  end
  def user_list
    id = params[:id]
    book = Book.eager_load(:user,:book_user_associations).find(id)
    @user_id = params[:user_id]
    @user = User.find_by_id(@user_id)
    user =book.users.present? ? book.users : []
    @issued_users = {}
    @book_id=book.id
    if user.present?
      book.book_user_associations.each do |assoc|
        @issued_users[assoc.user.name] =assoc.created_at
      end
    end

  end
  def add
    @user_id =params[:user_id]
  end

  def add_book
    @user_id =params[:user_id]
    @book = Book.create(book_params)
=begin
    @book.name=params["book_add_request"]["name"]
    @book.author=params["book_add_request"]["author"]
    @book.book_type=params["book_add_request"]["book_type"]
    @book.book_metadata =BookMetadata.new
    @book.book_metadata.total_available = params["book_add_request"]["book_metadata"]["total_available"].to_i
    @book.book_metadata.total_number = params["book_add_request"]["book_metadata"]["total_number"].to_i
    #book.book_metadata.save!
    book.save!
=end
    render "books/show"

  end



  private

  def book_params
    params.require(:book).permit(:name, :author, :book_type, book_metadata_attributes: [ :total_available, :total_number ])
  end

  def set_user
    @user =User.find_by_id(params[:user_id])
  end
end