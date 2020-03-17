package controllers

import javax.inject._
import play.api.mvc._


@Singleton
case class AuthenticateController @Inject() (
                                              cc:                  ControllerComponents
                                            ) extends AbstractController(cc)  {
  private val SESSION_KEY_USER_ID = "userId"
  def verify = Action { implicit request =>
    Ok("verify")
  }

  def resolve = Action { implicit request =>
    Ok("resolve")
  }

  def logout() = Action{
    Ok("logout")
  }
}

