import { defineConfig } from '@playwright/test';

const baseUrl = process.env.BASE_URL || 'http://localhost:3000';

export default defineConfig({
  timeout: 60000,
  testDir: './tests',
  use: {
    baseURL: baseUrl,
    headless: true,
    browserName: 'chromium',
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',
  },
});
