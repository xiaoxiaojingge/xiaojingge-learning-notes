return {
    {
        "neovim/nvim-lspconfig",
        event = { "BufReadPre", "BufNewFile" },
        dependencies = {
            "folke/neodev.nvim",
            "williamboman/mason.nvim",
            "williamboman/mason-lspconfig.nvim",
            "hrsh7th/cmp-nvim-lsp"
        },
        config = function()
            -- Setup language servers.
            local lspconfig = require("lspconfig")
            local capabilities = require("cmp_nvim_lsp").default_capabilities()

            local servers = {
                "lua_ls",
                "volar",
                "html",
                "tsserver",
                "pylsp"
            }

            for _, server in ipairs(servers) do
                lspconfig[server].setup({
                    capabilities = capabilities
                })
            end

            vim.api.nvim_create_autocmd("LspAttach", {
                group = vim.api.nvim_create_augroup("UserLspConfig", {}),
                callback = function(ev)
                    vim.bo[ev.buf].omnifunc = "v:lua.vim.lsp.omnifunc"

                    local opts = { buffer = ev.buf }

                    vim.keymap.set('n', 'gd', vim.lsp.buf.definition, opts)        -- 查看定义
                    vim.keymap.set('n', '<C-k>', vim.lsp.buf.signature_help, opts) -- 查看帮助
                    vim.keymap.set('n', '<leader>rn', vim.lsp.buf.rename, opts)    -- 变量重命名
                    vim.keymap.set('n', 'gr', vim.lsp.buf.references, opts)        -- 查看参考文献

                    vim.keymap.set("n", "<M-F>", function()
                        vim.lsp.buf.format({ async = true })
                    end, opts)

                    -- vim.cmd(
                    --     [[autocmd BufWritePre * lua vim.lsp.buf.format({ async = ture} )]]
                    -- ) -- 保存自动格式化
                end
            })
        end
    },
    {
        "jose-elias-alvarez/null-ls.nvim",
        event = { "BufReadPre", "BufNewFile" },
        dependencies = { "mason.nvim" },
        opts = function()
            local null_ls = require("null-ls")
            return {
                root_dir = require("null-ls.utils").root_pattern(".null-ls-root", ".neoconf.json", "Makefile", ".git"),
                sources = {
                    -- null_ls.builtins.formatting.stylua,
                    -- null_ls.builtins.formatting.prettier
                }
            }
        end
    }
}
