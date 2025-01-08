import http from 'k6/http';
import { check, sleep } from 'k6';

// Configuration
export const options = {
    stages: [
        { duration: '30s', target: 100 }, // Ramp-up to 100 users
        { duration: '1m', target: 100 },  // Stay at 100 users
        { duration: '30s', target: 0 },   // Ramp-down to 0 users
    ],
    thresholds: {
        http_req_duration: ['p(95)<200'], // 95% of requests should be below 200ms
        http_req_failed: ['rate<0.01'],   // Error rate should be below 1%
    },
};

// Test Data
const baseUrl = 'http://localhost:8080/api/v1'; // Change to your service URL
const testUrl = 'https://example.com'; // Sample long URL for testing

// Entry Point
export default function () {
    // Shorten URL API
    const shortenRes = http.post(`${baseUrl}/shorten`, JSON.stringify({ longUrl: testUrl }), {
        headers: { 'Content-Type': 'application/json' },
    });

    check(shortenRes, {
        'Shorten URL: Status is 200': (r) => r.status === 200,
        'Shorten URL: Has shortUrl': (r) => JSON.parse(r.body).shortUrl !== undefined,
    });

    // Redirect API (if shorten succeeded)
    if (shortenRes.status === 200) {
        const shortUrl = JSON.parse(shortenRes.body).shortUrl;

        // Simulate a redirect request
        const redirectRes = http.get(`${baseUrl}/${shortUrl}`);
        check(redirectRes, {
            'Redirect: Status is 302': (r) => r.status === 302,
        });
    }

    // Pause for 1 second between iterations
    sleep(1);
}
