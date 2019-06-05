package com.outr.arango.api

import com.outr.arango.api.model._
import io.youi.client.HttpClient
import io.youi.http.HttpMethod
import io.youi.net._
import io.circe.Json
import scala.concurrent.Future
import scribe.Execution.global
      
class AdminRoutingReload(client: HttpClient) {
  /**
  * Reloads the routing information from the collection *routing*.
  */
  def post(): Future[Json] = client
    .method(HttpMethod.Post)
    .path(path"/_admin/routing/reload", append = true) 
    .call[Json]
}