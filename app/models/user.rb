class User < ActiveRecord::Base
  has_one :user_password, -> { where is_active: true}
  belongs_to :user_type
  has_many :book_user_associations,:dependent => :destroy
  has_many :books ,:through => :book_user_associations
  has_many :user_login_histories
  has_many :user_otps
  scope :active, -> { where(state: 'active') }

  validates :email, presence: true , format: { with: URI::MailTo::EMAIL_REGEXP }
  validates :name ,presence: true
  validates :name ,uniqueness: true
  validates_numericality_of :age


  module USER_TYPE
    ADMIN = 'ADMIN'
    STUDENT ='STUDENT'
  end

  def is_admin
    (self.user_type.type == USER_TYPE::ADMIN) ? true : false
  end

  def login
    user_login_history = UserLoginHistory.new
    user_login_history.action = UserLoginHistory::ACTION_TYPE::LOGIN
    self.user_login_histories << user_login_history
    self.save!
  end
  handle_asynchronously :login
  def logout
    user_login_history = UserLoginHistory.new
    user_login_history.action = UserLoginHistory::ACTION_TYPE::LOGOUT
    self.user_login_histories << user_login_history
    self.save!
  end
  handle_asynchronously :logout
end