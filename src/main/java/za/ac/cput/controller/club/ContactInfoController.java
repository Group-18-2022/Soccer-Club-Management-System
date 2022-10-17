package za.ac.cput.controller.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.factory.club.ContactInformationFactory;
import za.ac.cput.service.club.impl.ContactInfoServiceImpl;

import javax.validation.Valid;
import java.util.List;
/**
 * This is the Contact information Controller
 * @author Charles Moses Lemmert (220498385)
 * **/
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/contactinformation/")
public class ContactInfoController {

    private final ContactInfoServiceImpl contactService;

    @Autowired
    public ContactInfoController(ContactInfoServiceImpl contactService){
        this.contactService = contactService;
    }

    @PostMapping("save")
    public ResponseEntity<ContactInformation> save(@Valid @RequestBody ContactInformation contactInformation){
        ContactInformation saveContacts = ContactInformationFactory.createContactInfo(
                contactInformation.getContactId(),contactInformation.getStreetNumber(),
                contactInformation.getStreetName(),contactInformation.getArea(),
                contactInformation.getCity(),contactInformation.getZipCode(),
                contactInformation.getPhoneNumber(),contactInformation.getEmailAddress());
            return ResponseEntity.ok(contactService.save(saveContacts));
    }
    @GetMapping("read/{id}")
    public ResponseEntity<ContactInformation> read(@PathVariable String id){
        ContactInformation readContacts = this.contactService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact information not found"));
        return ResponseEntity.ok(readContacts);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ContactInformation contactInformation) {
        this.contactService.delete(contactInformation);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        this.contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ContactInformation>> findAll(){
        List<ContactInformation> findContacts = this.contactService.findAllContacts();
        return ResponseEntity.ok(findContacts);
    }
}
