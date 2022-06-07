import { KeycloakService } from 'keycloak-angular';

//Function for initialize keycloak
export function initializeKeycloak(keycloak: KeycloakService):()=> Promise<boolean> {
  return () =>
      keycloak.init({
        config: {
          url: 'http://localhost:8180/auth',
          realm: 'booking',
          clientId: 'spa-booking',
        },
        initOptions:{
          checkLoginIframe:true,
          checkLoginIframeInterval: 25
        },
        loadUserProfileAtStartUp: true
      });
}
