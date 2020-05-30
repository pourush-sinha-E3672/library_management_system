class BookUserAssociationController < ApplicationController

  module Status
  ACTIVE = "active"
  CLOSED = "closed"
  end

  def associate_user_with_book
    user_id = params[:user_id]
    book_id = params[:book_id]
    book = Book.find(book_id)
    user = User.find(user_id)
    book_assoc = user.books.where(:id =>book_id)
    if !book_assoc.present?
      book_user_association = BookUserAssociation.new
      book_user_association.user_id = user_id
      book_user_association.book_id =book_id
      book_user_association.status =Status::ACTIVE
      book_user_association.save!
      book.book_metadata.total_available = book.book_metadata.total_available - 1
      book.book_metadata.save!
    end
    redirect_to  list_books_path(user_id: user_id)
  end

  def dissociate_user_with_book
    user_id = params[:user_id]
    book_id = params[:book_id]
    book = Book.find(book_id)
    user = User.find(user_id)
    book_assoc = BookUserAssociation.where(:book_id =>book_id,:user_id =>user_id ,:status =>Status::ACTIVE)
    if book_assoc.present?
      book_assoc.each do |bk|
        bk.status =Status::CLOSED
        bk.save!
      end
      book.book_metadata.total_available = book.book_metadata.total_available + 1
      book.book_metadata.save!
    end
    redirect_to  list_books_path(user_id: user_id)
  end
end