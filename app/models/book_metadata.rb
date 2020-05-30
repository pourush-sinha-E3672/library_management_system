class BookMetadata <ActiveRecord::Base
  self.table_name = "book_metadatas"
  belongs_to :book
  validates :total_available ,presence: true
  validates :total_number ,presence: true
  validates_numericality_of :total_available
  validates_numericality_of :total_number, :greater_than_or_equal_to => :total_available
end