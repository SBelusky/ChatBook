package sk.chatbook.security;

public enum ApplicationUserPermission {
    ADMIN_PERM("admin:perm");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
