require 'rails_helper'

RSpec.describe BookMetadata, type: :model do
  pending "add some examples to (or delete) #{__FILE__}"

  context "BookMetadata validation test" do
    it "ensure total_available presence" do
      book_metadata = BookMetadata.new
      book_metadata.total_number =4
      book_metadata.total_available =5

      expect(book_metadata.valid?).to eq(false)
    end

    it "ensure total_numner presence" do
       book_metadata = BookMetadata.new
       book_metadata.total_available =4
       expect(book_metadata.valid?).to eq(false)
    end

    it "ensure total_number greter then total_available presence" do
      book_metadata = BookMetadata.new
      book_metadata.total_available =4
      book_metadata.total_number =2
      expect(book_metadata.valid?).to eq(false)
    end
  end
end
