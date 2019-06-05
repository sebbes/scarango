package com.outr.arango.api

import com.outr.arango.api.model._
import io.youi.client.HttpClient
import io.youi.http.HttpMethod
import io.youi.net._
import io.circe.Json
import scala.concurrent.Future
import scribe.Execution.global
      
class AdminClusterHealth(client: HttpClient) {
  /**
  * Queries the health of the cluster for monitoring purposes. The response is a JSON object, containing the standard `code`, `error`, `errorNum`, and `errorMessage` fields as appropriate. The endpoint-specific fields are as follows:
  * 
  * - `ClusterId`: A UUID string identifying the cluster
  * - `Health`: An object containing a descriptive sub-object for each node in the cluster.
  *   - `<nodeID>`: Each entry in `Health` will be keyed by the node ID and contain the following attributes:
  *     - `Endpoint`: A string representing the network endpoint of the server.
  *     - `Role`: The role the server plays. Possible values are `"AGENT"`, `"COORDINATOR"`, and `"DBSERVER"`.
  *     - `CanBeDeleted`: Boolean representing whether the node can safely be removed from the cluster.
  *     - `Version`: Version String of ArangoDB used by that node.
  *     - `Engine`: Storage Engine used by that node.
  *     - `Status`: A string indicating the health of the node as assessed by the supervision (agency). This should be considered primary source of truth for coordinator and dbservers node health. If the node is responding normally to requests, it is `"GOOD"`. If it has missed one heartbeat, it is `"BAD"`. If it has been declared failed by the supervision, which occurs after missing heartbeats for about 15 seconds, it will be marked `"FAILED"`.
  * 
  *     Additionally it will also have the following attributes for:
  * 
  *     **Coordinators** and **DBServers**
  *     - `SyncStatus`: The last sync status reported by the node. This value is primarily used to determine the value of `Status`. Possible values include `"UNKNOWN"`, `"UNDEFINED"`, `"STARTUP"`, `"STOPPING"`, `"STOPPED"`, `"SERVING"`, `"SHUTDOWN"`.
  *     - `LastAckedTime`: ISO 8601 timestamp specifying the last heartbeat received.
  *     - `ShortName`: A string representing the shortname of the server, e.g. `"Coordinator0001"`.
  *     - `Timestamp`: ISO 8601 timestamp specifying the last heartbeat received. (deprecated)
  *     - `Host`: An optional string, specifying the host machine if known.
  * 
  *     **Coordinators** only
  *     - `AdvertisedEndpoint`: A string representing the advertised endpoint, if set. (e.g. external IP address or load balancer, optional)
  * 
  *     **Agents**
  *     - `Leader`: ID of the agent this node regards as leader.
  *     - `Leading`: Whether this agent is the leader (true) or not (false).
  *     - `LastAckedTime`: Time since last `acked` in seconds.
  */
  def get(): Future[Json] = client
    .method(HttpMethod.Get)
    .path(path"/_admin/cluster/health", append = true) 
    .call[Json]
}