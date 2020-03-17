package controllers

import action.SecuredAction
import javax.inject._
import models.UserRequest
import play.api.data._
import play.api.mvc._
import play.api.data.Forms._
import play.api.i18n.I18nSupport
import support.UserForm

@Singleton
class HomeController @Inject() (
                                 securedAction: SecuredAction,
    cc: ControllerComponents
) extends AbstractController(cc)  with I18nSupport {
  val form:Form[UserForm] = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText
    )(UserForm.apply)(UserForm.unapply)
  )

  def index = Action { implicit request =>
    Ok(views.html.index(form))
  }

}
