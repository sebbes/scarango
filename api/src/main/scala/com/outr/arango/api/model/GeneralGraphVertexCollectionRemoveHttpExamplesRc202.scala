package com.outr.arango.api.model

import io.circe.Json


case class GeneralGraphVertexCollectionRemoveHttpExamplesRc202(error: Boolean,
                                                               code: Option[Int] = None,
                                                               graph: Option[GraphRepresentation] = None)