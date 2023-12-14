import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { PreloadAllModules, provideRouter, withPreloading } from '@angular/router';

import { provideHttpClient } from '@angular/common/http';
import { APP_ROUTES } from './app-routes';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(APP_ROUTES,
    withPreloading(PreloadAllModules)),
  provideHttpClient(),
  importProvidersFrom(BrowserAnimationsModule)
  ]
};
