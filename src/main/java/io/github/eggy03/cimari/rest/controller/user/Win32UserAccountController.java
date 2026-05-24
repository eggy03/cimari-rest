package io.github.eggy03.cimari.rest.controller.user;

import io.github.eggy03.cimari.rest.entity.user.Win32UserAccount;
import io.github.eggy03.cimari.rest.exception.entity.ErrorResponse;
import io.github.eggy03.cimari.rest.service.user.Win32UserAccountService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/user")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "User")
public class Win32UserAccountController {

    private final Win32UserAccountService service;

    @GET
    @Path("/account")
    @Operation(summary = "List of Win32_UserAccount objects")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "500", description = "Failure",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<Win32UserAccount> getAll() {
        return service.get(15);
    }
}
