class UsersController < ApplicationController
  def get_user_details
  end

  def create_user
    sign_up_params = params[:sign_up_request]
    begin
      UsersHelper.validate_sign_up_request(sign_up_params)
    rescue LmsError => e
      redirect_to sign_up_path(error: e.message)
      return
    end
    user = User.new
    user.name = sign_up_params[:user]
    user.email = sign_up_params[:email]
    user.age = sign_up_params[:age]
    user.user_type_id = sign_up_params[:user_type_id]
    user_password = UserPassword.new
    user_password.password = sign_up_params[:password]
    user.user_passwords << user_password
    if user.valid?
      user.save!
      user_otp = UserOtp.new
      otp =user_otp.generate_otp
      user.user_otps << user_otp
      user.save!
      MailerJob.perform_later(user.id, otp)
      redirect_to sign_up_otp_path(:user_id =>user.id),notice: "Otp has been sent to registerd email id Please verify"
      return
    else
      redirect_to sign_up_path(error: user.errors.full_messages)
    end
  end

  def verify_otp
    user_id = params[:id]
    otp = params[:otp_sign_up_request][:otp]
    user = User.where(:id =>user_id).first
    if !user.present?
      redirect_to sign_up_otp_path(:user_id =>user_id),notice: "Incorrect USerId"
      return
    end
    otps = user.user_otps
    otps.each do |user_otp|
      if user_otp.otp==otp

        user.state='active'
        user.save!
        redirect_to root_path,notice: "User Successfully Signed in.Please login now"
        return
      end
    end
    redirect_to sign_up_otp_path(:user_id =>user_id),notice: "Incorrect otp"

  end
end