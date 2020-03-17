package action

import java.lang.ProcessBuilder.Redirect

import javax.inject.Inject
import models.UserRequest
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class SecuredAction @Inject() (
                                val parser:            BodyParsers.Default

                              )(implicit val executionContext: ExecutionContext)
  extends ActionBuilder[UserRequest, AnyContent]
    with ActionTransformer[Request, UserRequest] {
  override def transform[A](request: Request[A]): Future[UserRequest[A]] = Future.successful {
    val userId = request.session.get("userId")

    userId match {
      case Some(value) => new UserRequest(Some(value), request)
      case None => throw new Exception("User Not Found")
    }
  }

}

