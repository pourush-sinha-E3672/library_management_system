class LoginController < ApplicationController

  def home
    @error = params[:error]

  end

  def login
    user = params[:login_request][:user]
    password = params[:login_request][:password]

    begin
      user = LoginHelper.validate_login(user,password)
      user.login
      LoginHelper.start_session(user.id)
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
    LoginHelper.end_session(user.id)
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