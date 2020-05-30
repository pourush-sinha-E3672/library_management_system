module BooksHelper

  def self.action_link(user , book)
    if  book.is_issued(user.id)
      return link_to  'return' ,book_edit_path(book,user_id: user.id)
    end
    if book.is_available
      return link_to  'ISSUE' ,book_edit_path(book,user_id: user.id)
    else
      return 'NOT_AVAILABLE'
    end

  end
end