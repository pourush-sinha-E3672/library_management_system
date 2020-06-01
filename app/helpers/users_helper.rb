module UsersHelper
  def self.get_user_details(user_name)
    user = User.where(:name=>user_name,:state =>'active').first
  end

  def self.get_user_by_id(id)
    user = User.where(:id =>id).first
  end

  def self.validate_sign_up_request(sign_up_request)
    raise LmsError.new("pasword not matching",400)  if !sign_up_request[:password].eql? sign_up_request[:confirm_password]
    raise LmsError.new("User Already exist in Active State.Try with some other name",400) if User.where(:name =>sign_up_request[:user],:state=>'active').present?
  end
end