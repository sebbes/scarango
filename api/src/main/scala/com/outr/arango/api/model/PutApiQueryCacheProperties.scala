package com.outr.arango.api.model

import io.circe.Json

/**
  * PutApiQueryCacheProperties
  *
  * @param includeSystem whether or not to store results of queries that involve system collections.
  * @param maxEntrySize the maximum individual size of query results that will be stored per database-specific cache.
  * @param maxResults the maximum number of query results that will be stored per database-specific cache.
  * @param maxResultsSize the maximum cumulated size of query results that will be stored per database-specific cache.
  * @param mode the mode the AQL query cache should operate in. Possible values are *off*, *on* or *demand*.
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PutApiQueryCacheProperties(includeSystem: Option[Boolean] = None,
                                      maxEntrySize: Option[Long] = None,
                                      maxResults: Option[Long] = None,
                                      maxResultsSize: Option[Long] = None,
                                      mode: Option[String] = None)