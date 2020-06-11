class LoginController < ApplicationController

  def home
    @error = params[:error]

  end

  def login
    user_name = params[:login_request][:user]
    password = params[:login_request][:password]

    begin
      user =  User.includes(:user_password).where(:name=>user_name,:state =>'active').first
      if !user.present?
        redirect_to root_path(error:"Invalid user #{user}")
        return
      end

      if (!user.user_password.present? || !user.user_password.authenticate(password))
        redirect_to root_path(error:"Invalid password for user #{user}")
        return
      end
      user.login
      key ="user_session_#{user.id}"
      value={}
      session[:login_at] =Time.now.to_s
      session[:last_updated] = Time.now.to_s
      session[:expires_at] = Time.now + 60
      #$redis.setex(key, 180, value)
      session[:user_id] =user.id
    rescue LmsError => e
      redirect_to root_path(error: e.message)
      return
    end

    redirect_to list_books_path(user_id: user.id)

  end
  def logout
    user_id = params[:id]
    user = User.find(user_id)
    user.logout
    key ="user_session_#{user_id}"
    $redis.del(key)
    session[:user_id]=nil
    redirect_to root_path
  end

  def sign_up
    @error = params[:error]
  end

  def otp
    @error = params[:error]
    @user_id = params[:user_id]
  end

end