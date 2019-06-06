package com.outr.arango.api.model

import io.circe.Json

/**
  * PostBatchReplication
  *
  * @param ttl the time-to-live for the new batch (in seconds)
  *        
  *        A JSON object with the batch configuration.
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PostBatchReplication(ttl: Long)