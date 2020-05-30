class Book < ActiveRecord::Base
  has_one :book_metadata, class_name: BookMetadata
  accepts_nested_attributes_for :book_metadata
  has_many :book_user_associations
  has_many :users ,:through => :book_user_associations

  validates :name, presence: true
  validates :author, presence: true
  validates :book_type, presence: true

  def delete
    self.is_deleted =1
    self.save!
  end

  def is_available
    if self.book_metadata.total_available > 0
      true
    else
      false
    end

  end

  def is_issued(user_id)
    user = self.users.where(id: user_id)
    if (user.present?)
      true
    else
      false
    end

  end

end