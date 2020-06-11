module CommonActions
  extend ActiveSupport::Concern

  included do
    before_action :check_user_session, :check_if_user_exists
  end
  private
  def check_if_user_exists
    user_id = params[:user_id]
    user = User.where(:id =>user_id).first
    if(!user.present?)
      #redirect_to root_path,:alert=>"User does not exist please signup for for access"
      redirect_to root_path,:alert => "User does not exist please signup for for access"
      return
    end
  end

  def check_user_session
    user_id = session[:user_id]
    @user =User.active.where(:id =>user_id).first
    time_left = (Time.parse(session[:expires_at]) - Time.now).to_i

    # key ="user_session_#{user_id}"
    #session = $redis.get(key)
    if !(user_id.present? and  @user.present? and time_left > 0)
        #  value = JSON.parse  $redis.get(key).gsub('=>', ':')
        # value["last_updated"] = Time.now.to_s
        # $redis.setex(key, 180, value)
      flash.now[:alert] = "Your session is over Please login again for access"
      redirect_to root_path,:alert => "Your session is over Please login again for access"
      return
    else
      update_session_time
    end

  end

  def update_session_time
    session[:expires_at] = 1.minutes.from_now
  end
end