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
      title: 'Home',
      url: '',
      icon: 'home'
    },
    {
      title: 'Cidade',
      url: '/city',
      icon: 'speedometer'
    },
    {
      title: 'Viagem',
      url: '/travel',
      icon: 'paper-plane'
    },
    {
      title: 'Combustível',
      url: '/fuel',
      icon: 'thermometer'
    },
    {
      title: 'Mensal',
      url: '/monthly',
      icon: 'list-box'
    },
    {
      title: 'Cartão',
      url: '/card',
      icon: 'card'
    },
    {
      title: 'Motorista',
      url: '/driver',
      icon: 'person'
    },
    {
      title: 'Carro',
      url: '/car',
      icon: 'car'
    },
    {
      title: 'Multas',
      url: '/traffic-ticket',
      icon: 'filing'
    },
    {
      title: 'Sobre',
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
