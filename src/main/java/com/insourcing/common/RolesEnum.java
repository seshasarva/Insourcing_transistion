package com.insourcing.common;

public enum RolesEnum {

  ROLE_CAN("CANDIDATE"), ROLE_SU("SUPERUSER"), ROLE_TAG("TAG"),ROLE_HRBC("HRBC"), ROLE_DO("DEALOWNER"), ROLE_HRTM("TRANSITIONMANAGER"),
  ROLE_OM("ONBOARDINGMANAGER"), ROLE_PAN("PANEL"), ROLE_SME("SME");
	
	private String roleAssigned;
    private RolesEnum(String roleAssigned) {
        this.roleAssigned = roleAssigned;
    }
   
    @Override
    public String toString(){
        return roleAssigned;
    }
}

