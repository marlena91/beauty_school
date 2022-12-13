package com.marlena.beautyschool.service;

import com.marlena.beautyschool.constants.BeautySchoolConstants;
import com.marlena.beautyschool.model.Contact;
import com.marlena.beautyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(BeautySchoolConstants.OPEN);
        contact.setCreatedBy(BeautySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(BeautySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId, BeautySchoolConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
