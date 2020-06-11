class Book < ActiveRecord::Base
  include Elasticsearch::Model
  include Elasticsearch::Model::Callbacks
  has_one :book_metadata, class_name: BookMetadata ,:dependent => :destroy
  accepts_nested_attributes_for :book_metadata
  has_many :book_user_associations ,:dependent => :destroy
  has_many :users ,:through => :book_user_associations

  validates :name, presence: true
  validates :author, presence: true
  validates :book_type, presence: true
  accepts_nested_attributes_for :book_metadata, update_only: true


  settings do
    mappings dynamic: false do
      indexes :author, type: :text ,analyzer: :english
      indexes :name, type: :text, analyzer: :english
      indexes :book_type, type: :text, analyzer: :english
      indexes :is_deleted, type: :boolean
    end
  end

  def self.search_active(query)
    self.search({query: {
        bool: {
            must: [
                {
                    multi_match: {
                        query: query,
                        fields: [:author, :name, :book_type]
                    }
                },
                {
                    match: {
                        is_deleted: false
                    }
                }]
        }
    }})

  end

  def delete
    self.destroy!
  end

  def is_available?
     self.book_metadata.total_available > 0
  end

  def is_issued?(user_id)
     self.users.where(id: user_id).present?
  end

end