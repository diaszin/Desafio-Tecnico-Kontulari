import type { Config } from "tailwindcss";

export default {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      fontFamily:{
        inter: "var(--font-inter)"
      },
      colors:{
        // Cor do site da Kontulari
        "kontulari-color": "#1DE9B6"
      }
    },
  },
  plugins: [],
} satisfies Config;
