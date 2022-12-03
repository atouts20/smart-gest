package bj.prexed.rhumaineservice.service;

import bj.prexed.rhumaineservice.entities.Person;
import bj.prexed.rhumaineservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;

@Service
public class UtileService {


    private final PersonRepository userRepository;

    public UtileService(PersonRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String,String> authenticate(){
        return null;
    }

    public boolean verify(String verificationCode) {

        Person user = userRepository.findByVerificaToken(verificationCode);
        Calendar cal = Calendar.getInstance();
        if ((user == null ) && (user.getResetDate ().getTime () - cal.getTime().getTime()) <= 0 ) {
            return false;
        } else {
            user.setVerificaToken (null);
            user.setEmailVerified (true);
            userRepository.save(user);

            return true;
        }

    }
}

