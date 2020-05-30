require 'rails_helper'

RSpec.describe Book, type: :model do
  pending "add some examples to (or delete) #{__FILE__}"
  context "Book validation test" do
    it "ensure name presence" do
      book = Book.new
      book.author ="some thing"
      expect(book.valid?).to eq(false)
    end
    it "ensure Author name presence" do
      book = Book.new
      book.name ="something"
      expect(book.valid?).to eq(false)
    end

    it "ensure Book Type  presence" do
      book = Book.new
      book.name ="something"
      book.author ="some thing"
      expect(book.valid?).to eq(false)
    end

    it "ensure Book Type  presence" do
      book = Book.new
      book.name ="something"
      book.author ="some thing"
      book.book_type = "some thing"
      expect(book.valid?).to eq(true)
    end

  end
end
