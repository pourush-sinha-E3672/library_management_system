class Book < ActiveRecord::Base
  include Elasticsearch::Model
  include Elasticsearch::Model::Callbacks
  has_one :book_metadata, class_name: BookMetadata
  accepts_nested_attributes_for :book_metadata
  has_many :book_user_associations
  has_many :users ,:through => :book_user_associations

  validates :name, presence: true
  validates :author, presence: true
  validates :book_type, presence: true

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