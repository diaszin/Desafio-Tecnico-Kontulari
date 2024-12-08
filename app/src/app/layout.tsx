import type { Metadata } from "next";
import "./globals.css";

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
        className="antialiased"
      >
        {children}
      </body>
    </html>
  );
}
