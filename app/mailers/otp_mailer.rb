class OtpMailer < ApplicationMailer
  def send_otp_email(otp,email)
    @otp = otp
    mail(to: email, subject: "Library Mangement System signup Otp")

  end
end
