package com.revature.Service;

public class Reimbursement_Services {

	public void submitReimbursement(Reimbursement reimbursementToBeSubmitted) {
		Reimbursement latestReimbursement = reimbursements.get(reimbursements.size() - 1);
		int id = latestReimbursement.getId() + 1; //
		
		reimbursementToBeSubmitted.setId(id);
		reimbursementToBeSubmitted.setStatus(Status.PENDING);
		reimbursements.add(reimbursementToBeSubmitted);
	}
	
	public void update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
		for (Reimbursement reimbursement : reimbursements) {
			if (reimbursement.getId() == unprocessedReimbursement.getId()) {
				reimbursement.setResolver(resolverId);
				reimbursement.setStatus(updatedStatus);
				return;
			}
		}
		throw new RuntimeException("There was an error processing this reimburesment, please try again.");
	}
	
	public Reimbursement getReimbursementById(int id) {
		for(Reimbursement reimbursement : reimbursements) {
			if(reimbursement.getId() == id) {
				return reimbursement;
			}
		}
	return null;
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> pendingReimbursements = new ArrayList<>();
		
		for(Reimbursement reimbursement : reimbursements) {
			if (reimbursement.getStatus() == Status.PENDING) {
				pendingReimbursements.add(reimbursement);
			}
		}
		
		return pendingReimbursements;
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		
		for(Reimbursement reimbursement : reimbursements) {
			if (reimbursement.getStatus() == Status.APPROVED || reimbursement.getStatus() == Status.DENIED ) {
				resolvedReimbursements.add(reimbursement);
			}
		}
		
		return resolvedReimbursements;
	}
	
	public List<Reimbursement> getReimbursementByAuthor(int userId) {
		List<Reimbursement> userReimbursements = new ArrayList<>();
		
		for(Reimbursement r : reimbursements) {
			if(r.getAuthor() == userId || r.getResolver() == userId) {
				userReimbursements.add(r);
			}
		}
	
		return userReimbursements; 
	}	
}

