class BookUserAssociation < ActiveRecord::Base
  default_scope { where(status: "active") }
  belongs_to :book
  belongs_to :user
end