package com.outr.arango.api.model

import io.circe.Json

/**
  * PutAPINewTasks
  *
  * @param name The name of the task
  * @param command The JavaScript code to be executed
  * @param offset Number of seconds initial delay
  * @param params The parameters to be passed into command
  * @param period number of seconds between the executions
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PutAPINewTasks(name: String,
                          command: Option[String] = None,
                          offset: Option[Long] = None,
                          params: Option[String] = None,
                          period: Option[Long] = None)