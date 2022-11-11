package npc.martin.impalabackend.entity;

/**
 *
 * @author bikathi_martin
 */
public enum SystemRoles {
    //admin can edit the user account details
    ROLE_ADMIN,
    
    //editor can make changes to the animal data
    ROLE_EDITOR,
    
    //manager has both admin and editor roles as well as
    //can see the reports dashboard
    ROLE_MANAGER
}
