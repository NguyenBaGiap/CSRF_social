package models

import play.api.mvc.{ Request, WrappedRequest }

class UserRequest[A](val user: Option[String], request: Request[A])
  extends WrappedRequest[A](request)
