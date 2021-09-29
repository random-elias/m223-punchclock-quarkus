package ch.zli.m223.punchclock.controller;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "Find all entries")
    public List<Entry> list() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Delete entry by id", description = "The entry with the given id will be deleted out of the h2 db.")
    @Path("/{id}")
    public Entry delete(@PathParam("id") Long id) {
        return entryService.deleteEntry(id);
    }

    /*Attempt to pass Time wihthin URL
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update/{id}/{checkin}/{checkout}")
    public Entry update(@PathParam("id") Long id, @PathParam("checkin") String checkin, @PathParam("checkout") String checkout) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime parsedCheckin  = LocalDateTime.parse(checkin, formatter);
        LocalDateTime parsedCheckout  = LocalDateTime.parse(checkout, formatter);
        return entryService.updateEntry(id, parsedCheckin, parsedCheckout);
    } */

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edit entry by id", description = "The entry with the given id will be updated with the PUT-Method's body content and returned again")
    @Path("/{id}")
    public Entry update(@PathParam("id") Long id) {
        return entryService.updateEntry(id);
    }
}