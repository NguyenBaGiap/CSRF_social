package controllers

import action.SecuredAction
import javax.inject._
import play.api.mvc._

class SocialController @Inject()(securedAction: SecuredAction,cc: ControllerComponents) extends AbstractController(cc) {
  def list = securedAction{ implicit request =>

    Ok("skldnfsdk")
  }
}
