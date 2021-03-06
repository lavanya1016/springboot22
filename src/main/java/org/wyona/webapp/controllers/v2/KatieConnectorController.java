package org.wyona.webapp.controllers.v2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.wyona.webapp.models.katie.Domain;
import org.wyona.webapp.models.katie.QnA;
import org.wyona.webapp.models.katie.Sentence;

public interface KatieConnectorController {

    /**
     * Create tenant
     * @param domain Domain object containing domain Id and name
     */
    public ResponseEntity<String> createTenant(@RequestBody Domain domain);

    /**
     * Delete tenant
     * @param domainId Domain Id
     */
    public ResponseEntity<?> deleteTenant(String domainId);

    /**
     * Add/train a particular question/answer associated with a particular domain
     * @param qna Question and answer
     * @param domainId Domain Id QnA is associated with
     */
    public ResponseEntity<?> train(QnA qna, String domainId);

    /**
     * Get UUIDs of answers to question
     * @param question Asked question
     * @param domainId Domain Id of knowledge base
     * @return UUIDs of answers to question
     */
    public ResponseEntity<String[]> getAnswers(Sentence question, String domainId);

    /**
     * Delete a particular QnA
     * @param domainId Domain Id the QnA is associated with
     * @param uuid UUID of QnA
     */
    public ResponseEntity<?> deleteQnA(String domainId, String uuid);
}
