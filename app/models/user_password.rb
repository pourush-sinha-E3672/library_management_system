class UserPassword < ActiveRecord::Base
  has_secure_password

  belongs_to :user
  validates :password, presence: true

end