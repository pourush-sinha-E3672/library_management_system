class UserLoginHistory < ActiveRecord::Base
  belongs_to :user
  module ACTION_TYPE
    LOGIN ='login'
    LOGOUT ='logout'
  end
end