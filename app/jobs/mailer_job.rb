class MailerJob < ActiveJob::Base

  def perform(usr_id,otp)
    # Do something later
    user =User.find(usr_id)
    OtpMailer.send_otp_email(otp,user.email).deliver_now
  end
end
