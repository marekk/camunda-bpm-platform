/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import org.camunda.bpm.engine.rest.dto.CountResultDto;
import org.camunda.bpm.engine.rest.dto.repository.DeploymentDto;
import org.camunda.bpm.engine.rest.mapper.MultipartFormData;
import org.camunda.bpm.engine.rest.sub.repository.DeploymentResource;

@Path(DeploymentRestService.PATH)
@Produces(MediaType.APPLICATION_JSON)
public interface DeploymentRestService {

  public static final String PATH = "/deployments";

  @Path("/{id}")
  DeploymentResource getDeploymentById(@PathParam("id") String deploymentId);

  /**
   * Exposes the {@link DeploymentQuery} interface as a REST service.
   *
   * @param uriInfo
   * @param firstResult
   * @param maxResults
   * @return
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  List<DeploymentDto> getDeployments(@Context UriInfo uriInfo,
                                                   @QueryParam("firstResult") Integer firstResult,
                                                   @QueryParam("maxResults") Integer maxResults);

  @POST
  @Path("/deployment")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  DeploymentDto createDeployment(@Context UriInfo uriInfo, MultipartFormData multipartFormData);

  @GET
  @Path("/count")
  @Produces(MediaType.APPLICATION_JSON)
  CountResultDto getDeploymentsCount(@Context UriInfo uriInfo);

}
