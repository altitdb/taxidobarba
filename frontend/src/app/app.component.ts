import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { RouterEvent, NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent {

  pages = [
    {
      title: 'Daily Cash',
      url: '/daily',
      icon: 'speedometer'
    },
    {
      title: 'Travel Cash',
      url: '/travel',
      icon: 'paper-plane'
    },
    {
      title: 'Monthly Report',
      url: '/monthly-report',
      icon: 'list-box'
    },
    {
      title: 'Fuel',
      url: '/fuel',
      icon: 'thermometer'
    },
    {
      title: 'Card',
      url: '/card',
      icon: 'card'
    },
    {
      title: 'Driver',
      url: '/driver',
      icon: 'person'
    },
    {
      title: 'Car',
      url: '/car',
      icon: 'car'
    },
    {
      title: 'About',
      url: '/tabs/about',
      icon: 'information-circle'
    },
  ];

  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private router: Router
  ) {
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  ngOnInit() {
    this.router.events.subscribe((event: RouterEvent) => {
      if (event instanceof NavigationEnd) {
        this.pages.map(p => {
          return p['active'] = (event.url === p.url);
        });
      }
    });
  }
}
