class BooksController < ApplicationController
  before_action :check_user_session

  def list
    user_id =params[:user_id]
    user = UsersHelper.get_user_by_id(user_id)
    @is_admin = user.present? ? user.is_admin : false
    @user =user
    @book = Book.where(is_deleted: 0)

  end

  def edit
    id =params[:id]
    @user_id =params[:user_id]
    @book =Book.find(id)

  end

  def update
    id =params[:id]
    user_id =params[:user_id]

    book = Book.find(id)
    book.name=book["book"]["name"]  if (book.name != params["book"]["name"])
    book.author=params["book"]["author"]  if (book.author != params["book"]["author"])
    book.book_type=params["book"]["book_type"]  if (book.book_type != params["book"]["book_type"])
    book.book_metadata.total_available = params["book"]["book_metadata_attributes"]["total_available"].to_i  if (book.book_metadata.total_available != params["book"]["book_metadata_attributes"]["total_available"].to_i)
    book.book_metadata.total_number = params["book"]["book_metadata_attributes"]["total_number"].to_i  if (book.book_metadata.total_number != params["book"]["book_metadata_attributes"]["total_number"].to_i)
    book.book_metadata.save!
    book.save!
    redirect_to book_details_path(book,user_id: user_id)
=begin
    @book =Book.find(id)
=end
  end

  def show
    id = params[:id]
    @book = Book.find(id)
    @user_id = params[:user_id]
  end

  def delete
    user_id=params[:user_id]
    id = params[:id]
    book = Book.find(id)
    book.delete
    flash[:notice] = "Book #{book.name} deleted"
    redirect_to list_books_path(user_id: user_id)
  end
  def user_list
    id = params[:id]
    book = Book.find(id)
    @user_id = params[:user_id]
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
    user_id =params[:user_id]
    book = Book.new
    book.name=params["book_add_request"]["name"]
    book.author=params["book_add_request"]["author"]
    book.book_type=params["book_add_request"]["book_type"]
    book.book_metadata =BookMetadata.new
    book.book_metadata.total_available = params["book_add_request"]["book_metadata"]["total_available"].to_i
    book.book_metadata.total_number = params["book_add_request"]["book_metadata"]["total_number"].to_i
    book.book_metadata.save!
    book.save!
    redirect_to book_details_path(book,user_id: user_id)

  end

  private

  def check_user_session
    user_id = params[:user_id]
    if !user_id.present?
      render root_path
    end
    key ="user_session_#{user_id}"
    session = $redis.get(key)
    if session.present?
      value = JSON.parse  $redis.get(key).gsub('=>', ':')
      value["last_updated"] = Time.now.to_s
      $redis.setex(key, 180, value)
    else
       redirect_to root_path,:notice =>"Your session is over Please login again for access"
       return

    end

  end
end