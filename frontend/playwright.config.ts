import { defineConfig } from '@playwright/test';

export default defineConfig({
  testDir: './tests',
  projects: [
    {
      name: 'Chromium',
      use: {  baseURL: process.env.BASE_URL || 'http://localhost:3000', headless: true, browserName: 'chromium' },
    },
    /*{
      name: 'Firefox',
      use: { browserName: 'firefox' },
    },*/
  ],
  use: {
    baseURL: 'http://localhost:3000',
    headless: false, // set to true in CI
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',
  },
});
