class UserPassword < ActiveRecord::Base
  belongs_to :user
  validates :password, presence: true

end