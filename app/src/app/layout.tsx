import type { Metadata } from "next";
import "./globals.css";
import {Inter} from "next/font/google";

const interFont = Inter({
  weight: "variable",
  subsets: ["latin"],
  variable: "--font-inter"
})

export const metadata: Metadata = {
  title: "GithubSearch - Kontulari",
  description: "Desafio técnico para a vaga de Desenvolvedor Fullstack Júnior da Kontulari",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br">
      <body
        className={`${interFont.variable} antialiased`}
      >
        {children}
      </body>
    </html>
  );
}
